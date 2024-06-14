chmod +x /opt/keycloak/import-client-scope.sh

sleep 20
/opt/keycloak/bin/kcadm.sh config credentials --server http://keycloak:8080 --realm master --user $KEYCLOAK_ADMIN --password $KEYCLOAK_ADMIN_PASSWORD