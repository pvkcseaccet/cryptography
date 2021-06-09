#########################################
#Author: Vijay Kumar Ponraj
#Usage: sh installdeps.sh aes.txt
#########################################

#!/bin/bash

cd dependencies
while read url; do
    wget $url
done < $1
