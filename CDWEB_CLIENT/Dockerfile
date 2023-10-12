FROM node:16.14.0-alpine3.14 as builder
WORKDIR /app
COPY ./package*.json /app
RUN npm install
COPY . /app
RUN npm run build

FROM nginx:1.23.3-alpine
COPY --from=builder /app/build /usr/share/nginx/html
COPY --from=builder /app/default.conf /etc/nginx/conf.d/default.conf
