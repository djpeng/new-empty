/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.camunda.bpm.cockpit.test.sample.plugin.simple.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.camunda.bpm.cockpit.plugin.resource.AbstractPluginRootResource;
import org.camunda.bpm.cockpit.test.sample.plugin.simple.SimplePlugin;

/**
 * A test root resource
 *
 * @author nico.rehwaldt
 */
@Path("plugin/" + SimplePlugin.ID)
public class SimpleRootResource extends AbstractPluginRootResource {

  public SimpleRootResource() {
    super(SimplePlugin.ID);
  }

  @Path("{engine}/test")
  public SimpleResource getTestResource(@PathParam("engine") String engine) {
    return subResource(new SimpleResource(engine), engine);
  }
}
