#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "Simple helloworld application"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://helloworld.c"

S = "${WORKDIR}"
S1 = "/home/mxd/fsl-release-yocto/sources/meta-test/recipes-example/example/example-0.1"

do_compile() {
	     ${CC} helloworld.c -o helloworld
}

do_install() {
	     install -d ${D}${bindir}
	     install -d ${D}${sysconfdir}
		 mkdir -p ${D}${sysconfdir}/boa/
	     install -d ${D}/var
	     install -d ${D}/var/www/
	     install -d ${D}/var/www/cgi-bin
		 install -d ${D}${sysconfdir}/boa/
	     install -m 0755 helloworld ${D}${bindir}
	     install -m 0755 ${S1}/boa ${D}${sysconfdir}/boa/
	     install -m 0755 ${S1}/boa.conf ${D}${sysconfdir}/boa/
		 install -m 0755 ${S1}/mime.types ${D}${sysconfdir}
		 install -m 0755 ${S1}/capture ${D}/var/www/cgi-bin
		 install -m 0755 ${S1}/cgictest.cgi ${D}/var/www/cgi-bin
}

FILES_${PN} += "\
/etc/boa \
/ect/boa/boa \
/etc/boa/boa.conf \
/etc/mime.types \
/var/www \
/var/www/cgi-bin \
/var/www/cgi-bin/capture \
/var/www/cgi-bin/cgictest.cgi \
"
