# Domain Documentation

This documentation help you to use domain module. In this module [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
result will be returned by callback functional interfaces to presentation.

## Packaging

Each use case has it's own package and if use case need request class, it should exist at use case package.

## Use Cases

### Consumer use case

Use case that accepts request and returns no result. It's success state always contains null data.
If no error occurs, `onComplete` will be called. Otherwise `onError` contains throwable of error.

```kotlin
class DummyConsumerUseCase : ConsumerUseCase<DummyRequest>() {
    override suspend fun task(request: DummyRequest): UseCaseConsumerResult {
        return UseCaseConsumerResult(message = "if needed")
    }
}
```

 
### Single use case
Use case that accepts request and returns expected result. It's success state always contains data in type of expected.
If use case returns data, `onSuccess` has data.It's data is instance of `UseCaseResult` with type of data.
 If no error occurs, `onComplete` will be called at the end. Otherwise `onError` contains throwable of error.
```kotlin
class DummySingleUseCase(private val repo: DummyRepo) : SingleUseCase<DummyRepoRequest,String>() {
    override suspend fun task(request: DummyRepoRequest): UseCaseResult<String> {
        return UseCaseResult(repo.test(request))
    }
}
```

### Supplier use case
Use case that returns result  and it has'nt any request..  It's success state always contains data in type of expected.
If use case returns data, `onSuccess` has data.It's data is instance of `UseCaseResult` with type of data.
If no error occurs, `onComplete` will be called at the end. Otherwise `onError` contains throwable of error.

```kotlin
class DummySupplierUseCase(private val data: String) : SupplierUseCase<String>() {
    override suspend fun task(): UseCaseResult<String> {
        return UseCaseResult(data = data)
    }
}
```


## Repository

Each repository should be interface and instance of [Repository](/domain/Repository.kt)



 
