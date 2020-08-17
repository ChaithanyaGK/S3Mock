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

package com.adobe.testing.s3mock.util;

import com.adobe.testing.s3mock.domain.S3Exception;
import com.adobe.testing.s3mock.dto.ErrorResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class S3MockExceptionHandler implements ExceptionMapper<S3Exception> {

  private static final Logger LOG = LoggerFactory.getLogger(S3MockExceptionHandler.class);

  @Override
  public Response toResponse(final S3Exception s3Exception) {
    LOG.info("Responding with status {}: {}", s3Exception.getStatus(), s3Exception.getMessage());

    final ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setCode(s3Exception.getCode());
    errorResponse.setMessage(s3Exception.getMessage());

    return Response.status(s3Exception.getStatus())
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML).entity(errorResponse).build();

  }
}
