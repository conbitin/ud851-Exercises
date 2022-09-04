/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.background.sync;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class WaterReminderFirebaseJobService extends JobService {
    // DONE (3) WaterReminderFirebaseJobService should extend from JobService

    // DONE (4) Override onStartJob
        // DONE (5) By default, jobs are executed on the main thread, so make an anonymous class extending
        //  AsyncTask called mBackgroundTask.
            // DONE (6) Override doInBackground
                // DONE (7) Use ReminderTasks to execute the new charging reminder task you made, use
                // this service as the context (WaterReminderFirebaseJobService.this) and return null
                // when finished.
            // DONE (8) Override onPostExecute and call jobFinished. Pass the job parameters
            // and false to jobFinished. This will inform the JobManager that your job is done
            // and that you do not want to reschedule the job.

        // DONE (9) Execute the AsyncTask
        // DONE (10) Return true
    private AsyncTask mBackgroundTask;

    @Override
    public boolean onStartJob(@NonNull JobParameters job) {
        mBackgroundTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                ReminderTasks.executeTask(WaterReminderFirebaseJobService.this, ReminderTasks.ACTION_REMINDER_CHARGING);
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                jobFinished(job, false);
            }
        };
        mBackgroundTask.execute();
        return true;
    }


    // DONE (11) Override onStopJob
        // DONE (12) If mBackgroundTask is valid, cancel it
        // DONE (13) Return true to signify the job should be retried


    @Override
    public boolean onStopJob(@NonNull JobParameters job) {
        if (mBackgroundTask != null) mBackgroundTask.cancel(false);
        return true;
    }
}
