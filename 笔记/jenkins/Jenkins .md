```
docker run --name jenkins-docker --rm --detach \
  --privileged --network jenkins --network-alias docker \
  --env DOCKER_TLS_CERTDIR=/certs \
  --volume /usr/local/software/jenkins/jenkins-docker-certs:/certs/client \
  --volume /usr/local/software/jenkins/jenkins-data:/var/jenkins_home \
  --publish 2376:2376 docker:dind --storage-driver overlay2
  
  
  
  
```





```
docker run -d -p 8090:8080 -p 50000:50000 -v /mydata/docker/jenkins:/var/jenkins_home --name tfc_jenkins --restart always --privileged=true  -u root jenkinsci/blueocean:1.25.0-alpha-1-bcc31d32159f
```





```
docker exec -it 957088735bfb /bin/bash



0f4ef611380f48638adc21fcdec1d788
```

