(define (problem hanoi3)

  (:domain hanoi)

  (:objects
    d1 d2 d3 - disk
    r1 r2 r3 - rod
  )

  (:init
    (clear d3)

    (smaller d3 d2)
    (smaller d2 d1)
    (smaller d3 d1)

    (on d3 d2)
    (on d2 d1)
    (bottom d1 r1)

    (empty r2)
    (empty r3)
  )

  (:goal
    (and
      (empty r1)
      (empty r2)

      (clear d3)
      (on d3 d2)
      (on d2 d1)
      (bottom d1 r3)
    )
  )

)