FROM node:18.19.1-alpine
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
RUN docker run -p 0.0.0.0:4200:4200 cyberneexus/cybernexus-frontend
EXPOSE 4200
CMD ["node", "server.js"]
