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
package com.example.android.favoritetoys;

import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // DONE (1) Declare a TextView variable called mToysListTextView
    TextView mToyListTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DONE (3) Use findViewById to get a reference to the TextView from the layout
        mToyListTextView = (TextView) findViewById(R.id.tv_toy_names);

        String[] mToys = ToyBox.getToyNames();

        for (String toy:mToys) {
            mToyListTextView.append(toy + "\n\n\n");
        }

        // DONE (4) Use the static ToyBox.getToyNames method and store the names in a String array

        // DONE (5) Loop through each toy and append the name to the TextView (add \n for spacing)
    }
}