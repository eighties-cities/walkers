#!/usr/bin/env bash

sbt --mem 8500 "project model" "runMain walkers.simulation --data ./generated"

