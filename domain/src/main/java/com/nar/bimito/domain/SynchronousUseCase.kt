package com.nar.bimito.domain


abstract class SynchronousUseCase<Req, Res> : UseCase<Res> {

    abstract fun perform(request: Req? = null): Res
}