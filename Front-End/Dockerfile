FROM node:18.19.1-alpine
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
EXPOSE 443
CMD ["node", "server.js"]
