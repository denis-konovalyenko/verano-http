/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Vedran Grgo Vatavuk
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package hr.com.vgv.verano.http.mock;

import hr.com.vgv.verano.http.Dict;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Multiple matching criteria.
 * @since 1.0
 */
public class MultiMatching implements MatchingCriteria {

    /**
     * Matches.
     */
    private final Iterable<MatchingCriteria> matches;

    /**
     * Ctor.
     * @param matches Matches
     */
    public MultiMatching(final Iterable<MatchingCriteria> matches) {
        this.matches = matches;
    }

    @Override
    public final Collection<String> apply(final Dict dict) {
        final List<String> result = new ArrayList<>(0);
        for (final MatchingCriteria criteria: this.matches) {
            result.addAll(criteria.apply(dict));
        }
        return result;
    }
}
