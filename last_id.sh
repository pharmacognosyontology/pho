#!/usr/bin/env bash

grep -h PHO\: src/modules/* | cut -d $'\t' -f 1 | sort -u |tail -n 1