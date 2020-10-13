package uk.nhs.nhsx.covid19.android.app.util

import androidx.work.ListenableWorker
import timber.log.Timber
import uk.nhs.nhsx.covid19.android.app.common.Result
import uk.nhs.nhsx.covid19.android.app.common.Result.Failure
import uk.nhs.nhsx.covid19.android.app.common.Result.Success

fun <T> Result<T>.toWorkerResult(): ListenableWorker.Result =
    when (this) {
        is Success -> ListenableWorker.Result.success()
        is Failure -> {
            Timber.e(this.throwable, "WorkerResult")
            ListenableWorker.Result.failure()
        }
    }
