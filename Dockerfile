FROM debian:latest

RUN apt-get update && \
    apt-get -y install \
    apache2 \
    curl \
    wget \
    python \
    locales \
    default-jdk

RUN curl -L https://yt-dl.org/downloads/latest/youtube-dl -o /usr/local/bin/youtube-dl
RUN chmod +rx /usr/local/bin/youtube-dl

ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

COPY ./Init.sh /root/
COPY ./index.html /var/www/html
COPY ./Style.css /var/www/html

EXPOSE 80

RUN chmod +x /root/Init.sh
CMD ["/bin/bash", "/root/Init.sh"]
