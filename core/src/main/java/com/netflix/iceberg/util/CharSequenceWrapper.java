/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.netflix.iceberg.util;

import com.netflix.iceberg.types.Comparators;

/**
 * Wrapper class to adapt CharSequence for use in maps and sets.
 */
public class CharSequenceWrapper {
  public static CharSequenceWrapper wrap(CharSequence seq) {
    return new CharSequenceWrapper(seq);
  }

  private CharSequence wrapped;

  private CharSequenceWrapper(CharSequence wrapped) {
    this.wrapped = wrapped;
  }

  public CharSequenceWrapper set(CharSequence wrapped) {
    this.wrapped = wrapped;
    return this;
  }

  public CharSequence get() {
    return wrapped;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    CharSequenceWrapper that = (CharSequenceWrapper) other;
    return Comparators.charSequences().compare(wrapped, that.wrapped) == 0;
  }

  @Override
  public int hashCode() {
    int result = 177;
    for (int i = 0; i < wrapped.length(); i += 1) {
      char c = wrapped.charAt(i);
      result = 31 * result + (int) c;
    }
    return result;
  }
}
