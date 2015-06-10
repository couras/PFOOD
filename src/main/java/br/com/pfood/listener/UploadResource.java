/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.listener;

/**
 *
 * @author palazzio
 */
public class UploadResource {

   final static public int UPLOADING_STATUS = 0;

   final static public int UPLOADED_STATUS = 1;

   final static public int FAILED_STATUS = 2;

   private String uploadId_;

   private String fileName_;

   private String mimeType_;

   private String storeLocation_;

   private double uploadedSize_ = 0;

   private double estimatedSize_ = 0;

   //private int limitMB_ = UploadService.uploadLimitMB_;
   private int status_ = UPLOADING_STATUS;

   public UploadResource(String uploadId)
   {
      uploadId_ = uploadId;
   }

   public UploadResource(String uploadId, String fileName)
   {
      fileName_ = fileName;
      uploadId_ = uploadId;
   }

   public String getUploadId()
   {
      return uploadId_;
   }

   public String getFileName()
   {
      return fileName_;
   }

   public void setFileName(String fileName)
   {
      fileName_ = fileName;
   }

   public String getMimeType()
   {
      return mimeType_;
   }

   public void setMimeType(String mimeType)
   {
      mimeType_ = mimeType;
   }

   public String getStoreLocation()
   {
      return storeLocation_;
   }

   public void setStoreLocation(String path)
   {
      storeLocation_ = path;
   }

   public double getUploadedSize()
   {
      return uploadedSize_;
   }

   public void addUploadedBytes(double size)
   {
      uploadedSize_ += size;
   }

   public double getEstimatedSize()
   {
      return estimatedSize_;
   }

   public void setEstimatedSize(double size)
   {
      estimatedSize_ = size;
   }

   public int getStatus()
   {
      return status_;
   }

   public void setStatus(int status)
   {
      status_ = status;
   }
}
