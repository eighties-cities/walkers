#!/usr/bin/env bash

sbt --mem 8500 "project prepare" "runMain walkers.run --population-data data/nantes_health_v0.csv --generated-data ./generated"

