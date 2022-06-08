/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package group.rxcloud.cloudruntimes.domain.nativeproto;

/**
 * Native OSS AWS S3 API defined.
 */
public interface NativeAwsS3Runtimes {

    /*
syntax = "proto3";

package mosn.proto.runtime.v1;

import "google/protobuf/empty.proto";
import "google/protobuf/timestamp.proto";

option go_package = "mosn.io/layotto/spec/proto/extension/v1;s3";

service S3 {
  rpc InitClient(InitRequest) returns (google.protobuf.Empty){}
  rpc PutObject(stream PutObjectInput) returns(PutObjectOutput){}
  rpc GetObject(GetObjectInput) returns (stream GetObjectOutput){}
  rpc DeleteObject(DeleteObjectInput) returns (DeleteObjectOutput){}
  rpc PutObjectTagging(PutBucketTaggingInput) returns (PutBucketTaggingOutput){}
  rpc DeleteObjectTagging(DeleteObjectTaggingInput) returns(DeleteObjectTaggingOutput){}
  rpc GetObjectTagging(GetObjectTaggingInput) returns(GetObjectTaggingOutput){}
  rpc CopyObject(CopyObjectInput) returns(CopyObjectOutput){}
  rpc DeleteObjects(DeleteObjectsInput) returns(DeleteObjectsOutput){}
  rpc ListObjects(ListObjectsInput) returns(ListObjectsOutput){}
  rpc GetObjectAcl(GetObjectAclInput) returns(GetObjectAclOutput){}
  rpc PutObjectAcl(PutObjectAclInput) returns(PutObjectAclOutput){}
  rpc RestoreObject(RestoreObjectInput) returns(RestoreObjectOutput){}
  rpc CreateMultipartUpload(CreateMultipartUploadInput) returns(CreateMultipartUploadOutput){}
  rpc UploadPart(stream UploadPartInput) returns(UploadPartOutput){}
  rpc UploadPartCopy(UploadPartCopyInput) returns(UploadPartCopyOutput){}
  rpc CompleteMultipartUpload(CompleteMultipartUploadInput) returns(CompleteMultipartUploadOutput){}
  rpc AbortMultipartUpload(AbortMultipartUploadInput) returns(AbortMultipartUploadOutput){}
  rpc ListMultipartUploads(ListMultipartUploadsInput) returns(ListMultipartUploadsOutput){}
  rpc ListObjectVersions(ListObjectVersionsInput) returns(ListObjectVersionsOutput){}
}

message InitRequest {
    string store_name = 1;
    map<string, string> metadata = 2;
}

message GetObjectInput {
  string store_name = 1;
  string bucket = 2;
  string expected_bucket_owner = 3;
  string if_match = 4;
  string if_modified_since = 5;
  string if_none_match = 6;
  string if_unmodified_since = 7;
  string key = 8;
  int64  part_number = 9;
  string range = 10;
  string request_payer = 11;
  string response_cache_control = 12;
  string response_content_disposition = 13;
  string response_content_encoding = 14;
  string response_content_language = 15;
  string response_content_type = 16;
  string response_expires = 17;
  string sse_customer_algorithm = 18;
  string sse_customer_key = 19;
  string sse_customer_key_md5 = 20;
  string version_id = 21;
}
message GetObjectOutput {
  bytes body = 1;
}

message PutObjectInput{
    string store_name = 1;
    string acl = 2;
    bytes body = 3;
    string bucket = 4;
    string key = 5;
    bool bucket_key_enabled = 6;
    string cache_control = 7;
}
message PutObjectOutput{
    bool bucket_key_enabled = 1;
    string etag = 2;
}

message DeleteObjectInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
}
message DeleteObjectOutput{
    bool delete_marker = 1;
    string request_charged = 2;
    string version_id = 3;
}

message PutBucketTaggingInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
    map<string, string> tags = 4;
}
message PutBucketTaggingOutput{

}

message DeleteObjectTaggingInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
}
message DeleteObjectTaggingOutput{
    string version_id = 1;
}

message GetObjectTaggingInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
}
message GetObjectTaggingOutput{
    map<string, string> tags = 1;
}

message CopyObjectInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
    string copy_source = 4;
}
message CopyObjectOutput{

}


message Delete{
    repeated ObjectIdentifier objects = 1;
    bool quiet = 2;
}
message ObjectIdentifier{
    string key = 1;
    string version_id = 2;
}
message DeleteObjectsInput{
    string store_name = 1;
    string bucket = 2;
    Delete Delete = 3;
}
message DeleteObjectsOutput{

}

message ListObjectsInput{
    string store_name = 1;
    string bucket = 2;
    string delimiter = 3;
    string encoding_type = 4;
    string expected_bucket_owner = 5;
    string marker = 6;
    int32  maxKeys = 7;
    string prefix = 8;
    string request_payer = 9;
}
message ListObjectsOutput{
    repeated string common_prefixes = 1;
    repeated Object contents = 2;
    string delimiter = 3;
    string encoding_type = 4;
    bool is_truncated = 5;
    string marker = 6;
    int32 max_keys = 7;
    string name = 8;
    string next_marker = 9;
    string prefix = 10;
}
message Owner{
    string display_name = 1;
    string id = 2;
}
message Object{
    string etag = 1;
    string key = 2;
    google.protobuf.Timestamp last_modified = 3;
    Owner owner = 4;
    int64 size = 5;
    string storage_class = 6;
}

message Grantee{
    string display_name = 1;
    string email_address = 2;
    string id = 3;
    string type = 4;
    string uri = 5;
}
message Grant{
    Grantee grantee = 1;
    string permission = 2;
}
message GetObjectAclInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
}
message GetObjectAclOutput{
    repeated Grant grants = 1;
    Owner owner = 2;
    string request_charged = 3;
}

message PutObjectAclInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
    string acl = 4;
}
message PutObjectAclOutput{
    string request_charged = 1;
}

message RestoreObjectInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
}
message RestoreObjectOutput{
    string request_charged = 1;
    string restore_output_path = 2;
}

message CreateMultipartUploadInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
    string acl = 4;
    bool bucket_key_enabled = 5;
    string cache_control = 6;
    string content_disposition = 7;
    string content_encoding = 8;
    string content_language = 9;
    string content_type = 10;
    string expected_bucket_owner = 11;
    google.protobuf.Timestamp expires = 12;
    string grant_full_control = 13;
    string grant_read = 14;
    string grant_read_acp = 15;
    string grant_write_acp = 16;
    map<string, string> meta_data = 17;
    string object_lock_legal_hold_status = 18;
    string object_lock_mode = 19;
    google.protobuf.Timestamp object_lock_retain_until_date = 20;
    string request_payer = 21;
    string sse_customer_algorithm = 22;
    string sse_customer_key = 23;
    string sse_customer_key_md5 = 24;
    string sse_kms_encryption_context = 25;
    string sse_kms_key_id = 26;
    string server_side_encryption = 27;
    string storage_class = 28;
    string tagging = 29;
    string website_redirect_location = 30;
}
message CreateMultipartUploadOutput{
    string bucket = 1;
    string key = 2;
    google.protobuf.Timestamp abort_date = 3;
    string abort_rule_id = 4;
    bool bucket_key_enabled = 5;
    string request_charged = 6;
    string sse_customer_algorithm = 7;
    string sse_customer_key_md5 = 8;
    string sse_kms_encryption_context = 9;
    string sse_kms_key_id = 10;
    string server_side_encryption = 11;
    string upload_id = 12;
}

message UploadPartInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
    bytes  body = 4;
    int64  content_length = 5;
    string content_md5 = 6;
    string expected_bucket_owner = 7;
    int32  part_number = 8;
    string request_payer = 9;
    string sse_customer_algorithm = 10;
    string sse_customer_key = 11;
    string sse_customer_key_md5 = 12;
    string upload_id = 13;
}
message UploadPartOutput{
    bool bucket_key_enabled = 1;
    string etag = 2;
    string request_charged = 3;
    string sse_customer_algorithm = 4;
    string sse_customer_key_md5 = 5;
    string sse_kms_key_id = 6;
    string server_side_encryption = 7;
}

message UploadPartCopyInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
    string copy_source = 4;
    int32  part_number = 5;
    string upload_id = 6;
}

message CopyPartResult{
    string etag = 1;
    google.protobuf.Timestamp last_modified = 2;
}
message UploadPartCopyOutput{
    bool bucket_key_enabled = 1;
    CopyPartResult copy_part_result = 2;
    string copy_source_version_id = 3;
    string request_charged = 4;
    string sse_customer_algorithm = 5;
    string sse_customer_key_md5 = 6;
    string sse_kms_key_id = 7;
    string server_side_encryption = 8;
}

message CompletedPart{
    string etag = 1;
    int32 part_number = 2;
}
message CompletedMultipartUpload{
    repeated CompletedPart parts = 1;
}
message CompleteMultipartUploadInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
    string upload_id = 4;
    string request_payer = 5;
    string expected_bucket_owner = 6;
    CompletedMultipartUpload multipart_upload = 7;
}
message CompleteMultipartUploadOutput{
    string bucket = 1;
    string key = 2;
    bool bucket_key_enabled = 3;
    string etag = 4;
    string expiration = 5;
    string location = 6;
    string request_charged = 7;
    string sse_kms_keyId = 8;
    string server_side_encryption = 9;
    string version_id = 10;
}

message AbortMultipartUploadInput{
    string store_name = 1;
    string bucket = 2;
    string key = 3;
    string expected_bucket_owner = 4;
    string request_payer = 5;
    string upload_id = 6;
}
message AbortMultipartUploadOutput{
    string request_charged = 1;
}

message ListMultipartUploadsInput{
    string store_name = 1;
    string bucket = 2;
    string delimiter = 3;
    string encoding_type = 4;
    string expected_bucket_owner = 5;
    string key_marker = 6;
    int64  max_uploads = 7;
    string prefix = 8;
    string upload_id_marker = 9;
}
message Initiator{
    string display_name = 1;
    string id = 2;
}
message MultipartUpload{
    google.protobuf.Timestamp Initiated = 1;
    Initiator initiator = 2;
    string key = 3;
    Owner owner = 4;
    string storage_class = 5;
    string UploadId = 6;
}
message ListMultipartUploadsOutput{
    string bucket = 1;
    repeated string common_prefixes = 2;
    string delimiter = 3;
    string encoding_type = 4;
    bool is_truncated = 5;
    string key_marker = 6;
    int32 max_uploads = 7;
    string  next_key_marker = 8;
    string next_upload_id_marker = 9;
    string prefix = 10;
    string upload_id_marker = 11;
    repeated MultipartUpload uploads = 12;
}

message ListObjectVersionsInput{
    string store_name = 1;
    string bucket = 2;
    string delimiter = 3;
    string encoding_type = 4;
    string expected_bucket_owner = 5;
    string key_marker = 6;
    int64  max_keys = 7;
    string prefix = 8;
    string version_id_marker = 9;
}
message DeleteMarkerEntry{
    bool is_latest = 1;
    string key = 2;
    google.protobuf.Timestamp last_modified = 3;
    Owner owner = 4;
    string version_id = 5;
}
message ObjectVersion{
    string etag = 1;
    bool is_latest = 2;
    string key = 3;
    google.protobuf.Timestamp last_modified = 4;
    Owner owner = 5;
    int64 size = 6;
    string storage_class = 7;
    string version_id = 8;
}
message ListObjectVersionsOutput{
    repeated string common_prefixes = 1;
    repeated DeleteMarkerEntry delete_markers = 2;
    string delimiter = 3;
    string encoding_type = 4;
    bool is_truncated = 5;
    string key_marker = 6;
    int64  max_keys = 7;
    string name = 8;
    string next_key_marker = 9;
    string next_version_id_marker = 10;
    string prefix = 11;
    string version_id_marker = 12;
    repeated ObjectVersion versions = 13;
}
     */
}