FROM node:18.19.1-alpine
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
CMD ["node", "server.js", "--host", "0.0.0.0"]
