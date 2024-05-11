
FROM node:18.19.1 as build
WORKDIR /app
COPY . /app
RUN npm install
RUN npm run build

FROM nginx:1.21
COPY --from=build /app/dist /usr/share/nginx/html



