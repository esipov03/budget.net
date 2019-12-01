let data =[
    {
        id: "1",
        name: "Urbat.Tech",
        in_prog: "13",
        wait: '3',
        ready:'28',
        processes: [
            {
                id: '1',
                finder: '2',
                date_create: '13.05.2019',
                date_end: '20.05.2019',
                prev_proc: '-1',
                next_proc: '2'
            },
            {
                id: '4',
                finder: '2',
                date_create: '19.07.2019',
                date_end: '23.07.2019',
                prev_proc: '3',
                next_proc: '5'
            },
            {
                id: '6',
                finder: '3',
                date_create: '27.07.2019',
                date_end: '30.07.2019',
                prev_proc: '5',
                next_proc: '7'
            },
            {
                id: '8',
                finder: '-1',
                date_create: '09.08.2019',
                date_end: '19.08.2019',
                prev_proc: '7',
                next_proc: '-1'
            },
        ]
    },
    {
        id: "2",
        name: "bydget.net",
        in_prog: '3',
        wait: '0',
        ready:'28',
        processes: [
            {
                id: '2',
                finder: '3',
                date_create: '21.05.2019',
                date_end: '05.06.2019',
                prev_proc: '1',
                next_proc: '3'
            },
            {
                id: '5',
                finder: '1',
                date_create: '23.07.2019',
                date_end: '26.07.2019',
                prev_proc: '4',
                next_proc: '6'
            },
            {
                id: '9',
                finder: '-1',
                date_create: '09.08.2019',
                date_end: '03.09.2019',
                prev_proc: '7',
                next_proc: '-1'
            },
        ]
    },
    {
        id: "3",
        name: "overmind",
        in_prog: '4',
        wait: '43',
        ready:'28',
        processes: [
            {
                id: '3',
                finder: '1',
                date_create: '06.06.2019',
                date_end: '19.07.2019',
                prev_proc: '2',
                next_proc: '4'
            },
            {
                id: '7',
                finder: [
                    '1',
                    '2'
                ],
                date_create: '01.08.2019',
                date_end: '09.08.2019',
                prev_proc: '6',
                next_proc: [
                    '8', 
                    '9'
                ]
            }
        ]
    }
];
console.log(JSON.stringify(data));