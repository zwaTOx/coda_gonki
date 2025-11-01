FROM node:lts-alpine

# install simple http server for serving static content
RUN npm install -g http-server

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build

EXPOSE 3000
CMD ["http-server", "dist", "-p", "3000"]