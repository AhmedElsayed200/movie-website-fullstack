FROM node:18-alpine
WORKDIR /frontend
ENV path="./node_modules/.bin:$PATH"
COPY . .
RUN npm run build
CMD ["npm", "start"]