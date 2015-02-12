#!/bin/sh

rm -rf docs/
jsdoc www/pushlink.js --pedantic --verbose --debug -R README.md -d docs