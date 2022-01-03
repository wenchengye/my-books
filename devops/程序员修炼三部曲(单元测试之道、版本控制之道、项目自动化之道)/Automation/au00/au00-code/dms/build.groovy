/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import java.io.File

class Build {

  srcDir = "src"
  buildDir = "build"
  buildProdDir = buildDir + File.separator + "prod"
  vendorLibDir = "vendor" + File.separator + "lib"
    
  ant = new AntBuilder()
      
  void clean() {
    ant.delete(dir: buildDir)
  }

  void prepare() {
    clean()
    ant.mkdir(dir: buildProdDir)     
  }

  void compile() {
    prepare()
    ant.javac(srcdir: srcDir, 
              destdir: buildProdDir, 
              classpath: projectClasspath())
  }

  String projectClasspath() {
    ant.path {
      fileset(dir: vendorLibDir) {
        include(name: "**/*.jar")
      }
    }
  }

  void instrumentJARs() {
    scanner = ant.fileScanner {
      fileset(dir: vendorLibDir)
    }
    scanner.each { instrument(it) }
  }

  void instrument(file) {
    println("Instrumenting ${file}")
    // insert code here
  }
}

new Build().compile()
