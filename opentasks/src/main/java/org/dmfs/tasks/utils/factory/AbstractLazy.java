/*
 * Copyright 2017 dmfs GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dmfs.tasks.utils.factory;

/**
 * Simple, non-thread safe base implementation for {@link Lazy}.
 *
 * @author Gabor Keszthelyi
 */
// TODO Use it from dmfs java tools library when available
public abstract class AbstractLazy<T> implements Lazy<T>
{
    private final Factory<T> mFactory;

    private T mValue;


    public AbstractLazy(Factory<T> factory)
    {
        mFactory = factory;
    }


    @Override
    public final T get()
    {
        if (mValue == null)
        {
            mValue = mFactory.create();
        }
        return mValue;
    }
}
