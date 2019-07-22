faas remove -f joinrq.yml --gateway 10.20.0.170:8071
sleep  6
faas-cli deploy -f joinrq.yml --gateway 10.20.0.170:8071
