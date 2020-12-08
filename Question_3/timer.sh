#! /bin/sh
javac looptest.java
   for i in 1 ; do
   time java looptest $i
   done