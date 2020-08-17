/*
 *  Copyright 2017-2019 Adobe.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.adobe.testing.s3mock.domain;

import java.nio.file.Path;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * DTO representing a bucket.
 */
@XmlRootElement(name = "Bucket")
public class Bucket {

  private String name;

  private String creationDate;

  private Path path;

  /**
   * Constructs a new {@link Bucket}.
   *
   * @param bucketPath path of bucket
   * @param name of bucket
   * @param creationDate date of creation.
   */
  public Bucket(final Path bucketPath, final String name, final String creationDate) {
    this.name = name;
    this.creationDate = creationDate;
    path = bucketPath;
  }

  public Bucket() {
  }

  @XmlElement
  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(final String creationDate) {
    this.creationDate = creationDate;
  }

  @XmlElement
  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @XmlTransient
  public Path getPath() {
    return path;
  }

  public void setPath(final Path bucketPath) {
    path = bucketPath;
  }
}
