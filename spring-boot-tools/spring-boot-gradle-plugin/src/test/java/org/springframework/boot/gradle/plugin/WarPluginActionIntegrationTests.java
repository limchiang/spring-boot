/*
 * Copyright 2012-2017 the original author or authors.
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

package org.springframework.boot.gradle.plugin;

import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.gradle.testkit.GradleBuild;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for {@link JavaPluginAction}.
 *
 * @author Andy Wilkinson
 */
public class WarPluginActionIntegrationTests {

	@Rule
	public GradleBuild gradleBuild = new GradleBuild();

	@Test
	public void noBootWarTaskWithoutWarPluginApplied() {
		assertThat(this.gradleBuild.build("taskExists", "-PtaskName=bootWar").getOutput())
				.contains("bootWar exists = false");
	}

	@Test
	public void applyingWarPluginCreatesBootWarTask() {
		assertThat(this.gradleBuild
				.build("taskExists", "-PtaskName=bootWar", "-PapplyWarPlugin")
				.getOutput()).contains("bootWar exists = true");
	}

	@Test
	public void noBootWebSoftwareComponentWithoutJavaPluginApplied() {
		assertThat(this.gradleBuild.build("componentExists", "-PcomponentName=bootWeb")
				.getOutput()).contains("bootWeb exists = false");
	}

	@Test
	public void applyingJavaPluginCreatesBootWebSoftwareComponent() {
		assertThat(this.gradleBuild
				.build("componentExists", "-PcomponentName=bootWeb", "-PapplyWarPlugin")
				.getOutput()).contains("bootWeb exists = true");
	}

}
