FROM quay.io/keycloak/keycloak:25.0.0

COPY ./config/realm-export.json /opt/keycloac/data/import/realm-export.json
COPY import-client-scope.sh /opt/keycloak/import-client-scope.sh
ENV UIR_KEYCLOAK 'http://keycloak_web:8080/realms/applicationSpring'
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "/opt/keycloak/bin/kc.sh start-dev --import-realm -Dkeycloak.migration.action=import -Dkeycloak.migration.provider=singleFile -Dkeycloak.migration.file=/tmp/realm-export.json && sh /opt/keycloak/import-client-scope.sh" ]