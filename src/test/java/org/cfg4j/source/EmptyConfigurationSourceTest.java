/*
 * Copyright 2015 Norbert Potocki (norbert.potocki@nort.pl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cfg4j.source;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.cfg4j.source.context.DefaultEnvironment;
import org.cfg4j.source.context.Environment;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmptyConfigurationSourceTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  private EmptyConfigurationSource source;

  @Before
  public void setUp() throws Exception {
    source = new EmptyConfigurationSource();
  }

  @Test
  public void shouldReturnEmptyConfiguration() throws Exception {
    assertThat(source.getConfiguration(new DefaultEnvironment())).isEmpty();
  }

  @Test
  public void refreshShouldNotChangeConfiguration() throws Exception {
    source.refresh();
    assertThat(source.getConfiguration(new DefaultEnvironment())).isEmpty();
  }

  @Test
  public void shouldReturnEmptyConfigurationForAnyEnvironment() throws Exception {
    assertThat(source.getConfiguration(mock(Environment.class))).isEmpty();
  }
}