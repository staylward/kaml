/*

   Copyright 2018 Charles Korn.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

package com.charleskorn.kaml

import ch.tutteli.atrium.api.cc.en_GB.toBe
import ch.tutteli.atrium.verbs.assert
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object YamlNullTest : Spek({
    describe("a YAML null value") {
        describe("testing equivalence") {
            val nullValue = YamlNull(Location(2, 3))

            on("comparing it to the same instance") {
                it("indicates that they are equivalent") {
                    assert(nullValue.equivalentContentTo(nullValue)).toBe(true)
                }
            }

            on("comparing it to another null value with the same location") {
                it("indicates that they are equivalent") {
                    assert(nullValue.equivalentContentTo(YamlNull(Location(2, 3)))).toBe(true)
                }
            }

            on("comparing it to another null with a different location") {
                it("indicates that they are equivalent") {
                    assert(nullValue.equivalentContentTo(YamlNull(Location(2, 4)))).toBe(true)
                }
            }

            on("comparing it to a scalar value") {
                it("indicates that they are not equivalent") {
                    assert(nullValue.equivalentContentTo(YamlScalar("some content", Location(2, 3)))).toBe(false)
                }
            }

            on("comparing it to a list") {
                it("indicates that they are not equivalent") {
                    assert(nullValue.equivalentContentTo(YamlList(emptyList(), Location(2, 3)))).toBe(false)
                }
            }

            on("comparing it to a map") {
                it("indicates that they are not equivalent") {
                    assert(nullValue.equivalentContentTo(YamlMap(emptyMap(), Location(2, 3)))).toBe(false)
                }
            }
        }

        describe("converting the content to a human-readable string") {
            it("always returns the value 'null'") {
                assert(YamlNull(Location(1, 1)).contentToString()).toBe("null")
            }
        }
    }
})
