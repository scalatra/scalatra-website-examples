package com.constructiveproof.example.models

import org.slf4j.LoggerFactory

case class User(id:String)               {

  val logger = LoggerFactory.getLogger(getClass)

  def forgetMe = {
    logger.info("User: this is where you'd invalidate the saved token in you User model")
  }

}
