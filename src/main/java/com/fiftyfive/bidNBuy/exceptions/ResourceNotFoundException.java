package com.fiftyfive.bidNBuy.exceptions;

import com.fiftyfive.bidNBuy.util.Constants;

public class ResourceNotFoundException extends RuntimeException{

  public ResourceNotFoundException(String resourceName, String resourceId) {
    super(String.format(Constants.RESOURCE_NOT_FOUND_EXCEPTION, resourceName, resourceId));
  }

}
