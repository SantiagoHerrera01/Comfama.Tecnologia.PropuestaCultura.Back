FROM khipu/openjdk17-alpine
VOLUME /tmp
RUN addgroup -g 1001 -S appuser && adduser -u 1001 -S appuser  -G appuser
USER appuser
HEALTHCHECK --interval=5m --timeout=3s CMD curl -f http://localhost:3321/propuestascultura/actuator/health/ || exit 1
COPY ./build/libs/propuestaCultura-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7003
ENTRYPOINT ["java","-Djava.awt.headless=true","-Duser.timezone=America/Bogota","-jar","/app.jar"]
