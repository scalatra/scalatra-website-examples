#!/usr/bin/env bash

# run 'sbt test' on every project

set -e

# These are necessary in order to test the deployment/scala-jelastic project.
export JELASTIC_USERNAME="you@you.com"
export JELASTIC_PWD="iluvyou"

# Run the test suite for each project.
for SCRIPT in `find . -name sbt -type f -perm -u=x`
do
    OLD_PWD=`pwd`
    PROJ=`dirname $SCRIPT`
    echo '########################################################'
    echo "BUILDING $PROJ                                          "
    echo '########################################################'
    cd $PROJ
    ./sbt test
    cd $OLD_PWD
done

