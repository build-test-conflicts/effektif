package com.effektif.mongo;/* Copyright (c) 2015, Effektif GmbH.
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
 * limitations under the License. */

import org.bson.types.ObjectId;

import com.effektif.workflow.api.model.WorkflowId;
import com.effektif.workflow.impl.json.JsonObjectWriter;
import com.effektif.workflow.impl.json.JsonReader;
import com.effektif.workflow.impl.json.JsonTypeMapper;
import com.effektif.workflow.impl.json.JsonWriter;
import com.effektif.workflow.impl.json.types.AbstractTypeMapper;

/**
 * Maps a {@link WorkflowId} to a MongoDB JSON ID field for serialisation and deserialisation.
 *
 * TODO Can this subclass WorkflowIdStreamMapper?
 * @author Peter Hilton
 */
public class WorkflowIdMongoMapper extends AbstractTypeMapper<WorkflowId> implements JsonTypeMapper<WorkflowId> {

  @Override
  public Class<WorkflowId> getMappedClass() {
    return WorkflowId.class;
  }

  @Override
  public void write(WorkflowId objectValue, JsonWriter jsonWriter) {
    JsonObjectWriter jsonObjectWriter = (JsonObjectWriter) jsonWriter;
    jsonObjectWriter.writeValue(new ObjectId(objectValue.getInternal()));
  }

  @Override
  public WorkflowId read(Object jsonValue, JsonReader jsonReader) {
    return new WorkflowId(jsonValue.toString());
  }
}
