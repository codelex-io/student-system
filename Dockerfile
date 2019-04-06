FROM gradle:5.2.1-jdk11

VOLUME /tmp

COPY . /home/gradle/student-system
WORKDIR /home/gradle/student-system

ENTRYPOINT ["gradle"]