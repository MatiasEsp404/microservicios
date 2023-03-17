@echo off

REM Ejecutar los scripts en ventanas separadas
start "" /d "./car-service/" init-car-service.sh
start "" /d "./moto-service/" init-moto-service.sh
start "" /d "./user-auth-service/" init-user-auth-service.sh

REM Cerrar el archivo
exit /b 0
