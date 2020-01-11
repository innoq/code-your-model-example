#!/bin/sh

PROJECT_ROOT="`cd "${0%/*}/.."; pwd`"

exec groovy -cp $PROJECT_ROOT/src/main/groovy $PROJECT_ROOT/scripts/use-model.groovy "$@"; exit $?