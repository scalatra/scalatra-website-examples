package com.constructiveproof.example.models

import org.slf4j.{Logger, LoggerFactory}

case class User(id:String)               {

  val logger: Logger = LoggerFactory.getLogger(getClass)

  def forgetMe(): Unit = {
    logger.info("User: this is where you'd invalidate the saved token in you User model")
  }

}
