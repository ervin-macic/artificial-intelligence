(define (problem hanoi3)

  (:domain hanoi)

  (:objects
    d1 d2 d3 - disk
    r1 r2 r3 - thing
  )

  (:init

    ;; tower on r1
    (on d1 r1)
    (on d2 d1)
    (on d3 d2)

    ;; clear objects
    (clear d3)
    (clear r2)
    (clear r3)

    ;; size ordering
    (smaller d3 d2)
    (smaller d3 d1)
    (smaller d3 r1)
    (smaller d3 r2)
    (smaller d3 r3)

    (smaller d2 d1)
    (smaller d2 r1)
    (smaller d2 r2)
    (smaller d2 r3)

    (smaller d1 r1)
    (smaller d1 r2)
    (smaller d1 r3)
  )

  (:goal
    (and
      (on d1 r3)
      (on d2 d1)
      (on d3 d2)
    )
  )

)