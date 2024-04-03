package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import kotlinx.coroutines.delay

suspend fun main() {
    println(UserService().findUser(1L, null))
}

interface Continuation {
    suspend fun resumeWith(data: Any?)
}

class UserService {
    private val userProfileRepository = UserProfileRepository()
    private val userImageRepository = UserImageRepository()

    private abstract class FindUserContinuation: Continuation {
        var label = 0
        var profile: Profile? = null
        var image: Image? = null
    }

    suspend fun findUser(
        userId: Long,
        continuation: Continuation? = null
    ): UserDto {
        val stateMachine = continuation as? FindUserContinuation
            ?: object : FindUserContinuation() {
                override suspend fun resumeWith(data: Any?) {
                    when (label) {
                        0 -> {
                            profile = data as Profile
                            label = 1
                        }

                        1 -> {
                            image = data as Image
                            label = 2
                        }
                    }

                    findUser(userId, this)
                }
            }

        when (stateMachine.label) {
            0 -> {
                // 0단계 - 초기 시작
                println("get profile")
                userProfileRepository.findProfile(userId, stateMachine)
            }

            1 -> {
                // 1단계 - 1차 중단 후 재시작
                println("get image")
                 userImageRepository.findImage(stateMachine.profile!!, stateMachine)
            }
        }

        // 2단계 - 2차 중단 후 재시작
        return UserDto(stateMachine.profile!!, stateMachine.image!!)
    }
}

data class UserDto(
    val profile: Profile,
    val image: Image
)

class Image

class Profile

class UserImageRepository {
    suspend fun findImage(
        profile: Profile,
        continuation: Continuation
    ): Unit {
        delay(100)

        continuation.resumeWith(Image())
    }
}

class UserProfileRepository {
    suspend fun findProfile(
        userId: Long,
        continuation: Continuation
    ): Unit {
        delay(100)

        continuation.resumeWith(Profile())
    }
}
