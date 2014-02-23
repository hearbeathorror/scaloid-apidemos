/*
 * Copyright (C) 2007 The Android Open Source Project
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
package com.example.android.apis.view

// Need the following import to get access to the app resources, since this
// class is in a sub-package.

import com.example.android.apis.R
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import android.widget.AdapterView.OnItemSelectedListener

class Spinner1 extends Activity {
  private[view] def showToast(msg: CharSequence) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show
  }

  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.spinner_1)
    val s1: Spinner = findViewById(R.id.spinner1).asInstanceOf[Spinner]
    var adapter: ArrayAdapter[CharSequence] = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    s1.setAdapter(adapter)
    s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener {
      def onItemSelected(parent: AdapterView[_], view: View, position: Int, id: Long) {
        showToast("Spinner1: position=" + position + " id=" + id)
      }

      def onNothingSelected(parent: AdapterView[_]) {
        showToast("Spinner1: unselected")
      }
    })
    val s2: Spinner = findViewById(R.id.spinner2).asInstanceOf[Spinner]
    adapter = ArrayAdapter.createFromResource(this, R.array.planets, android.R.layout.simple_spinner_item)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    s2.setAdapter(adapter)
    s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener {
      def onItemSelected(parent: AdapterView[_], view: View, position: Int, id: Long) {
        showToast("Spinner2: position=" + position + " id=" + id)
      }

      def onNothingSelected(parent: AdapterView[_]) {
        showToast("Spinner2: unselected")
      }
    })
  }
}