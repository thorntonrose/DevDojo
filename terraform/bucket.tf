#//////////////////////////////CONFIGURATION/////////////////////////////

provider "aws" {
  region = "us-east-1"
}

# Variables
variable "myregion" {
  type    = "string"
  default = "us-east-1"
}

variable "accountId" {
  type    = "string"
  default = "<accountId>"
}

#${var.instancePurpose}
variable "name" {
  type    = "string"
  default = "ttr"
}

//terraform {
//  backend "s3" {
//    bucket = "dev-dojo"
//    #key    = "terraform/${var.customerId}/terraform.tfstate"
//    region = "us-east-1"
//  }
//}

#Create an S3 bucket
resource "aws_s3_bucket" "my_s3_bucket" {
  bucket = "${var.name}-bucket"
  acl    = "private"

  tags {
    Name        = "CE"
    Environment = "Dev"
  }
}

#Create folder in my_s3_bucket
resource "aws_s3_bucket_object" "my_folder" {
  bucket = "${aws_s3_bucket.my_s3_bucket.id}"
  acl    = "private"
  key    = "example/"
  source = "/dev/null"
}
