@echo off

REM Ejecutar los scripts en ventanas separadas
start "" /d "C:/Users/Usuario/Documents/GitHub/Microservicios/car-service/" init-car-service.sh
start "" /d "C:/Users/Usuario/Documents/GitHub/Microservicios/moto-service/" init-moto-service.sh
start "" /d "C:/Users/Usuario/Documents/GitHub/Microservicios/user-auth-service/" init-user-auth-service.sh

REM Cerrar el archivo
exit /b 0
