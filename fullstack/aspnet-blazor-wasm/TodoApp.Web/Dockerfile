FROM mcr.microsoft.com/dotnet/sdk:6.0 AS build
WORKDIR /src
COPY . .
RUN dotnet restore ./TodoApp.Web 
RUN dotnet build ./TodoApp.Web -c Release -o /app/build

FROM build AS publish
RUN dotnet publish ./TodoApp.Web -c Release -o /app/publish

FROM nginx:alpine AS final
WORKDIR /usr/share/nginx/html
COPY --from=publish /app/publish/wwwroot .
COPY ./TodoApp.Web/nginx.conf /etc/nginx/nginx.conf